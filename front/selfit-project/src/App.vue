<template>
  <div>
    <span v-if="chk">
      <TheHeaderNav />
    </span>
  </div>
  <span class="updown">
    <button @click="chk = !chk">{{ chk ? "ㅡ" : "ㅡ" }}</button>
  </span>
  <hr />

  <br />
  <RouterView />
</template>

<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";
import { ref } from "vue";
const chk = ref(false);

if (
  sessionStorage.length === 0 ||
  (sessionStorage.getItem("loginId") == "" &&
    sessionStorage.getItem("userName") == "") ||
  (sessionStorage.getItem("loginId") == null &&
    sessionStorage.getItem("userName") == null)
) {
  chk.value = false;
} else {
  chk.value = true;
}
</script>

<style>
@font-face {
  font-family: "ChosunNm";
  src: url("assets/fonts/ChosunNm.ttf") format("truetype");
  font-weight: 400;
}
body {
  font-family: "ChosunNm", sans-serif !important;
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
