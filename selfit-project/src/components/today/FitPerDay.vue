<template>
  <div class="fit-per-day">
    <!-- 여기에 각 영상의 썸네일 및 정보를 나열합니다. -->
    <!-- 예시로 몇 개의 div를 추가했습니다. -->
    <div v-for="n in 10" :key="n" class="thumbnail">
      영상 {{ n }} <!-- 여기에 썸네일과 영상 정보를 추가하세요 -->
    </div>
  </div>
</template>

<script>
export default {
  name: "FitPerDay",
  props: {
    day: {
      type: String,
      required: true
    }
  },
  // 여기에 컴포넌트 로직을 추가하세요.
  // 예를 들어, 서버에서 요일에 맞는 데이터를 가져오는 로직 등
};
</script>

<style scoped>
.fit-per-day {
  overflow-y: auto; /* 세로 스크롤 활성화 */
  height: 500px; /* 이 값은 조정 가능 */
  border: 1px solid #ccc; /* 박스 스타일 */
  padding: 10px;
}

.thumbnail {
  margin-bottom: 20px; /* 썸네일 간의 간격 */
  background-color: #f0f0f0; /* 썸네일 배경색 */
  padding: 10px;
  border-radius: 5px;
}
</style>
