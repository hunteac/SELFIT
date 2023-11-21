<template>
  <div>
    <h2>오늘의 운동</h2>
    <FitPerDay />
  </div>
</template>

<script setup>
import FitPerDay from "@/components/today/FitPerDay.vue";
</script>

<style scoped>
h2 {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2em;
  color: #4a4a4a;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
}
</style>
