<template>
    <div id="container">
        <header>
          <img src="@/assets/selfit_logo.png" alt="SELFIT 로고" class="logo">
            <nav>
                <RouterLink to="/"> Today's FIT </RouterLink>
                <RouterLink to="/youtube"> VideoSearch </RouterLink>
                <RouterLink :to="{ name: 'boardList' }"> My Routine</RouterLink>
<!--                <RouterLink :to="{ name: 'calender' }">캘린더 보기</RouterLink> |-->
            </nav>
        </header>
    </div>
</template>

<script setup>

</script>

<style  scoped>
#container {
    text-align: center;
}
.logo {
  float: left;
  height: 150px;
  margin-top: 15px;
  position: relative;
  left: 20px;
}
header{
  background-color: #FEFEFE;
}

nav {
    padding: 30px;
    //background-color: #37ADD6;
}

nav a {
    font-weight: bold;
    text-decoration: none;
    color: #8AAAE5;
    font-size: 35px;
    letter-spacing: 2px;
    margin-right: 40px;
}

nav a.router-link-exact-active {
    color:#F3A950;
}
</style>