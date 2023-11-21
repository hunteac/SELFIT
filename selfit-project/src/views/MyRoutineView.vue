<template>
  <div>
    <div class="button-container">
      <button v-for="day in days" :key="day">{{ day }}</button>
    </div>

    <div class="text-center">
    </div>
    <RouterView />
  </div>
</template>

<script setup>
import { RouterView } from "vue-router";
import { ref } from 'vue';

const days = ref(['월', '화', '수', '목', '금', '토', '일']);
</script>


<style scoped>
.button-container {
  display: flex;
  justify-content: space-between;
  max-width: 100%;
}
.button-container button {
  padding: 10px 20px;
  margin: 5px;
  border: 1px solid #ccc;
  background-color: #f8f8f8;
  flex: 1;
  min-width: 100px;
}
</style>
  