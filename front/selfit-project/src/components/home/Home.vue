<template>
  <span style="font-size: 40px; margin-left: 25%">
    내 루틴은 내가 만든다! 셀핏
  </span>
  <span
    class="about"
    style="
      cursor: pointer;
      font-size: 20px;
      color: #f0edcc;
      margin-left: 250px;
      padding-left: 1%;
      padding-right: 1%;
      background-color: #02343f;
    "
    @click="pushAbout"
  >
    About US
  </span>
  <div style="display: flex; justify-content: center; margin-left: 50px">
    <button v-show="!loginChk" class="btn" @click="pushLogin">로그인</button>
    <div style="display: flex; justify-content: center; height: 600px">
      <img src="src/assets/selfit2.png" alt="selfit" />
    </div>
    <button v-show="!loginChk" class="btn" @click="pushRegister">
      가입하기
    </button>
  </div>
  <div style="display: flex; justify-content: center; font-size: 30px">
    <div v-if="loginChk">
      <span class="highlight">{{ userName }}</span
      >님 오늘도 즐거운 운동되세요!
    </div>
    <div v-if="!loginChk">
      <span class="highlight"></span>오늘도 즐거운 운동되세요!
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import router from "@/router";

const userName = ref(sessionStorage.getItem("userName"));
const loginChk = ref(false);

if (
  sessionStorage.length === 0 ||
  (sessionStorage.getItem("loginId") == "" &&
    sessionStorage.getItem("userName") == "") ||
  (sessionStorage.getItem("loginId") == null &&
    sessionStorage.getItem("userName") == null)
) {
  loginChk.value = false;
} else {
  loginChk.value = true;
}

const pushAbout = function () {
  router.push("about");
};
const pushLogin = function () {
  router.push("login");
};
const pushRegister = function () {
  router.push("register");
};
</script>

<style scoped>
.btn {
  background-color: white;
  font-size: 30px;
  margin: 1%;
}
.highlight {
  color: rgb(8, 0, 122); /* 원하는 색상으로 설정 */
}
</style>
