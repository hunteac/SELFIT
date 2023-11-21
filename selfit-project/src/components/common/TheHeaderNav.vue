<template>
  <div id="container">
    <header>
      <img src="@/assets/selfit_logo.png" alt="SELFIT 로고" class="logo" @click="pushHome"/>
      <nav>

        <RouterLink to="/today"> Today's FIT</RouterLink>
        <RouterLink to="/youtube"> VideoSearch</RouterLink>
        <RouterLink to="/myroutine"> My Routine</RouterLink>
      </nav>
    </header>
  </div>
</template>
<script setup>
import router from "@/router";
const pushHome = function () {
  router.push("/")
}
</script>

<style scoped>
#container {
  text-align: center;
}

.logo {
  float: left;
  height: 150px;
  margin-top: 10px;
  position: relative;
  left: 20px;
}

header {
  background-color: #FEFEFE;
}

nav {
  padding: 30px;
//background-color: #37ADD6;
}

nav a {
  font-weight: bold;
  text-decoration: none;
//color: #8AAAE5; color: #0A174E;
  font-size: 30px;
  letter-spacing: 2px;
  margin: 40px;
}

nav a.router-link-exact-active {
//color:#F3A950; color: #F5D042;
}
</style>