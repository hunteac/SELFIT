<template>
  <div class="fit-per-day">
    <div v-if="getDayRoutine.dayRoutineResult">
      <span
        v-for="routineVideo in getDayRoutine.dayRoutineResult"
        :key="routineVideo.videoId"
        class="video-wrapper"
      >
        <iframe
          v-if="routineVideo.num === num"
          id="routineVideoList"
          title="iframe Example 2"
          width="400"
          height="300"
          style="border: none"
          :src="
            routineVideo.videoId +
            '?autoplay=1&mute=1&controls=0&start=' +
            routineVideo.start +
            '&end=' +
            routineVideo.end
          "
        ></iframe>
      </span>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { getDayRoutineStore } from "@/stores/routine.js";

const getDayRoutine = getDayRoutineStore();

const week = new Array(
  "일요일",
  "월요일",
  "화요일",
  "수요일",
  "목요일",
  "금요일",
  "토요일"
);

const today = new Date().getDay();
const todayLabel = week[today];
const num = ref(1);

onMounted(() => {
  getDayRoutine.dayRoutineMethod(todayLabel);
});
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
