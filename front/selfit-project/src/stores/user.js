import { ref } from "vue";
import { defineStore } from "pinia";
import { useRouter } from "vue-router";
import axios from "axios";


const REST_USER_API = "http://localhost:8080/userapi/user";

export const useJoinStore = defineStore("join", () => {
  const router = useRouter();
  const joinResult = ref("");
  const joinMethod = function (data) {
    let user = {
      id: data.id,
      pwd: data.pwd,
      userName: data.userName,
    };
    axios
      .post("http://localhost:8080/userapi/user", user, {
        header: { "Content-type": "application/json" },
      })
      .then((res) => {
        if (res.data == "success") {
          console.log(res.data);
          router.push("/login");
        } else {
          console.log(res.data);
          router.push("/Register");
        }
        joinResult.value = res.data;
      });
  };
  return {
    joinResult,
    joinMethod,
  };
});

export const useLoginStore = defineStore("login", () => {
  const loginId = ref("");
  const router = useRouter();
  const loginResult = ref("");
  const loginUser = ref("");
  const loginMethod = function (id, pwd) {
    let data = {
      id: id,
      pwd: pwd,
    };

    axios
      .post(`http://localhost:8080/userapi/user/login`, data, {
        headers: { "Content-Type": "application/json" },
      })
      .then((res) => {
        if (res.data == "success") {
          alert("로그인 성공");
          loginId.value = id;
          router.push("/today");
          loginResult.value = "success";
          sessionStorage.setItem("loginId", loginId.value);
        } else {
          alert("로그인 실패");
          loginResult.value = "fail";
        }
      });
  };

  const logoutMethod = function () {
    let ask = confirm("로그아웃 하시겠습니까?");
    if (ask) {
      loginId.value = "";
      router.push("/");
    }
  };

  // 유저 객체 가져오기
  const getById = function (loginId) {
    axios.get(`${REST_USER_API}/${loginId}`).then((res) => {
      loginUser.value = res.data;
    });
  };

  return {
    loginMethod,
    loginId,
    logoutMethod,
    loginResult,
    loginUser,
    getById,
  };
});
