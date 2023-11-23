<template>
  <div>
    <h2>O요일의 운동</h2>
    <br>
    <br>

    <FitPerDay class="fit-per-day" />
  </div>
</template>

<script setup>
import FitPerDay from "@/components/today/FitPerDay.vue";
</script>

<style scoped>
@font-face {
  font-family: 'ChosunNm';
  src: url('../assets/fonts/ChosunNm.ttf') format('truetype');
}
body {
  font-family: 'ChosunNm', sans-serif;
}
h2 {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2em;
  color: #4a4a4a;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
}
.fit-per-day {
  max-width: 1000px;
  margin: 0 auto;
}
</style>
