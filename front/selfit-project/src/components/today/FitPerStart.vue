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
          id="player"
          title="player"
          width="1000"
          height="650"
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
import { ref, onMounted, onUpdated } from "vue";
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
var num = 1;

onMounted(() => {
  getDayRoutine.dayRoutineMethod(todayLabel);
});
</script>

<style scoped>
.video-wrapper {
  display: flex;
  justify-content: center;
}
.fit-per-day {
  border: 1px solid #ccc; /* 박스 스타일 */
  padding: 10px;

}
</style>
