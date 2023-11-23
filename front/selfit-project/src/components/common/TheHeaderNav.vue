<template>
  <div id="container">
    <header>
      <div class="symmetrical-div">
        <div class="per">
          log-out
        </div>
        <br>
        <div class="per">
          OO님 <br>
          안녕하세요
        </div>

      </div>
      <img
          src="@/assets/selfit_logo.png"
          alt="SELFIT 로고"
          class="logo"
          @click="pushHome"
      />
      <nav>
        <RouterLink to="/today"> 오늘의 운동</RouterLink>
        <RouterLink to="/youtube">비디오 검색</RouterLink>
        <RouterLink to="/myroutine">나만의 루틴</RouterLink>
      </nav>
    </header>
  </div>
</template>
<script setup>
import router from "@/router";
const pushHome = function () {
  router.push("/");
};
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
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.per {
  padding-right: 40px;
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
  color: #0A174E;
  font-size: 35px;
  letter-spacing: 3px;
  margin: 60px;
}

nav a.router-link-exact-active {
   color: #F5D042;
}
</style>
