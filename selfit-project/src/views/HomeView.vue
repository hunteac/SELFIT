<template>
  <div style="display: flex; justify-content: center; height: 700px">
    <img src="src/assets/selfit2.png" alt="selfit" />
  </div>
  <div style="display: flex; justify-content: center">
    <button class="btn" @click="pushLogin">LOG-IN</button>
    <button class="btn" @click="pushRegister">SIGN-UP</button>
  </div>

  <br />
  <span style="font-size: 40px; margin-left: 30%"> MY ROUTINE </span>
  <br />
  <span style="font-size: 40px; margin-left: 25%">
    내 루틴은 내가 만든다! 셀핏
  </span>
  <span style="cursor: pointer" @click="pushToday">아무말</span>
  <a :href="today" style="display: flex; justify-content: right">ABOUT US</a>
</template>

<script setup>
import router from "../router";
const pushToday = function () {
  router.push("today");
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
  background-color: gainsboro;
  font-size: 30px;
  margin: 1%;
}

</style>


