<template>
  <div class="fit-per-day">
    <div v-if="getDayRoutine.dayRoutineResult">
      <span
        v-for="routineVideo in getDayRoutine.dayRoutineResult"
        :key="routineVideo.videoId"
        class="video-wrapper"
      >
        <iframe
          v-if="routineVideo.num == num"
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
        <div v-if="listChk">등록된 리스트가 없습니다.</div>
      </span>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, onUpdated } from "vue";
import { getDayRoutineStore } from "@/stores/routine.js";
import router from "@/router";

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

const listChk = ref(false);
const today = new Date().getDay();
const todayLabel = week[today];
var num = sessionStorage.getItem("num");

onMounted(() => {
  getDayRoutine.dayRoutineMethod(todayLabel);
});

onUpdated(async () => {
  let temp = Number(sessionStorage.getItem("num")) - 1;

  if (getDayRoutine.dayRoutineResult.length !== 0) {
    const result = getDayRoutine.dayRoutineResult.sort((a, b) => a.num - b.num);
    if (temp < result.length) {
      const cnt = result[temp].end - result[temp].start;

      console.log(cnt);

      // setTimeout을 Promise로 감싸서 동기적으로 처리
      await new Promise((resolve) => setTimeout(resolve, cnt * 1000));

      temp = Number(sessionStorage.getItem("num"));
      sessionStorage.setItem("num", temp + 1);
      location.reload();
    } else {
      sessionStorage.setItem("num", 1);
      router.push("/complete");
    }
  } else {
    listChk = true;
  }
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
