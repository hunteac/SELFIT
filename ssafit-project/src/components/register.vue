<template>
  <main class="container">
    <div class="register-page">
      <h1>Regist</h1>
      <div class="form">
        <form class="register-form">
          <input type="text" placeholder="ID" />
          <input type="password" placeholder="password" />
          <input type="text" placeholder="email address" />
          <input type="text" placeholder="name" />
          <input type="number" placeholder="age" />
          <button>회원 등록</button>
        </form>
      </div>
    </div>
  </main>
</template>

<script setup></script>

<style scoped>
.container {
  width: 100%;
  height: auto;
}
.register-page {
  width: 360px;
  padding: 7% 0 8%;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #ffffff;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  margin: 0 0 15px;
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #3396f4;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #ffffff;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,
.form button:active,
.form button:focus {
  background: #3396f4;
}

.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: green;
  text-decoration: none;
}

.container {
  position: relative;
  z-index: 1;
  max-width: 100%;
  margin: 0 auto;
  height: auto;
  min-height: 100%;
  padding-bottom: 70px;
}
</style>
