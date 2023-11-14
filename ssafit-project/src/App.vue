<template>
  <header>
    <nav class="header-nav">
      <div>
        <a href="#"><h1>SSAFIT</h1></a>
      </div>
      <RouterLink to="/">home</RouterLink> |
      <RouterLink to="/login">login</RouterLink> |
      <RouterLink to="register">regist</RouterLink>
    </nav>
  </header>

  <RouterView />
  <footer>
    <ul class="footer-list">
      <li><a href="#">개인정보 처리방침</a></li>
      <li><a href="#">이용 약관</a></li>
      <li>&copy; SSAFY</li>
    </ul>
  </footer>
</template>

<script setup></script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

header {
  height: 70px;
  background-color: #3396f4;
  color: white;
  line-height: 70px;
  padding: 0px 30px;
}

.nav-menu {
  margin-right: 10px;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

a {
  text-decoration: none;
  color: whitesmoke;
}

footer {
  bottom: 0;
  background-color: #3396f4;
  color: white;
  width: 100%;
  height: 70px;
  line-height: 70px;
}

.footer-list {
  display: flex;
  justify-content: center;
  align-items: center;
}

.footer-list a {
  margin: 0px 10px;
}
</style>
