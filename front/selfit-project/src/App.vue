<template>
  <div>
    <span v-if="chk">
      <THeHeaderNav />
    </span>
  </div>
  <span class="updown">
    <button @click="chk = !chk">{{ chk ? "ㅡ" : "ㅡ" }}</button>
  </span>
  <hr>

  <br />
  <RouterView />
</template>

<script setup>
import THeHeaderNav from "./components/common/THeHeaderNav.vue";
import { ref } from "vue";
const chk = ref(true);
</script>

<style>

@font-face {
  font-family:'ChosunNm';
  src: url('assets/fonts/ChosunNm.ttf') format('truetype');
  font-weight: 400;
}
body {
  font-family: 'ChosunNm', sans-serif !important;
}



.updown {
  display: flex;
  justify-content: center;
}
.updown button {
  color: grey;
  font-size: 30px;
}


</style>
