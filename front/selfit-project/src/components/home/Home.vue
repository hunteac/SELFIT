<template>
    <span style="font-size: 40px; margin-left: 25%">
    내 루틴은 내가 만든다! 셀핏
  </span>
  <span style="cursor: pointer;font-size: 20px;margin-left: 250px;background-color: #b224ef" @click="pushAbout"> About US </span>
  <div style="display: flex; justify-content: center; margin-left: 50px" >
    <button class="btn" @click="pushLogin">로그인</button>
    <div style="display: flex; justify-content: center; height: 600px">
      <img src="src/assets/selfit2.png" alt="selfit" />
    </div>
    <button class="btn" @click="pushRegister">가입하기</button>
  </div>

</template>

<script setup>
import router from "@/router";
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
</style>
