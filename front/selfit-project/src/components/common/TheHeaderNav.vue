<template>
  <div id="container">
    <header>
      <div class="symmetrical-div">
        <br />
        <br />
        <br />
        <div class="per">
          <button v-if="!loginChk" style="width: 60px" @click="mypage">
            {{ userName }}님
          </button>
        </div>
        <div v-if="!loginChk" class="per">
          <button @click="logout">logout</button>
        </div>
      </div>
      <div>
        <img
          src="@/assets/selfit_logo.png"
          alt="SELFIT 로고"
          class="logo"
          @click="pushHome"
        />
      </div>
      <div>
        <nav>
          <RouterLink to="/today"> 오늘의 운동</RouterLink>
          <RouterLink to="/youtube">비디오 검색</RouterLink>
          <RouterLink to="/myroutine">나만의 루틴</RouterLink>
        </nav>
      </div>
    </header>
  </div>
</template>
<script setup>
import router from "@/router";
import { ref, onMounted } from "vue";
import { useLoginStore } from "@/stores/user";

const loginChk = ref(false);
const loginStore = useLoginStore();
const pushHome = function () {
  router.push("/");
};

const logout = function () {
  loginStore.logoutMethod();
  location.href = "/";
};

const userName = ref(sessionStorage.getItem("userName"));

if (
  sessionStorage.length === 0 ||
  (sessionStorage.getItem("loginId") == "" &&
    sessionStorage.getItem("userName") == "")
) {
  loginChk.value = true;
} else {
  loginChk.value = false;
}
</script>

<style scoped>
#container {
  text-align: center;
  position: relative;
}

.logo {
  float: left;
  height: 130px;
  position: absolute;
  left: 120px;
  width: 130px;
  margin-top: 10px;
}

.symmetrical-div {
  float: right;
  height: 130px;
  width: 130px;
  position: absolute;
  right: 120px;
  margin-top: 10px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: end;
}
.per {
  padding-right: 30px;
}
header {
  background-color: #fefefe;
  min-width: 300px;
}

nav {
  margin-top: 30px;
  display: inline-block;
  vertical-align: top;
}

nav a {
  font-weight: bold;
  text-decoration: none;
  color: #0a174e;
  font-size: 35px;
  letter-spacing: 3px;
  margin: 60px;
}

nav a.router-link-exact-active {
  color: #f5d042;
}
</style>
