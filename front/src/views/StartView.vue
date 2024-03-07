<template>
  <FitPerStart />
  <div class="container">
    <button class="button" @click="pushToday">포기하기</button>
  </div>
  <br />
</template>

<script setup>
import FitPerStart from "@/components/today/FitPerStart.vue";
import router from "@/router";
const pushToday = function () {
  router.push("/today");
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center; /* 가운데 정렬 */
  align-items: center;
}
.button {
  padding: 10px 10px;
  background-color: blue; /* 기본 배경색 */
  color: white; /* 텍스트 색상 */

  border-radius: 5px; /* 둥근 모서리 */
  cursor: pointer; /* 마우스 오버 시 커서 변경 */
  transition: background-color 0.3s; /* 색상 변경 애니메이션 */
}

/* 마우스 오버 시 버튼 스타일 */
.button:hover {
  background-color: red; /* 마우스 오버 시 배경색 */
}
</style>
