<template>
  <div>
    <div class="upline">
      <div class="tmp">{{ week[today] }} 운동 리스트</div>
      <img
        class="img"
        src="src/assets/youngcha.png"
        alt="selfit"
        @click="pushStart"
      />
    </div>
  </div>
  <div class="video-wrapper" v-if="getDayRoutine.dayRoutineResult">
    <span
      v-for="routineVideo in getDayRoutine.dayRoutineResult"
      :key="routineVideo.videoId"
    >
      <div>
        <iframe
          class="video"
          id="videoList"
          title="iframe Example 2"
          width="400"
          height="300"
          style="border: none"
          :src="routineVideo.videoId"
        ></iframe>
      </div>
    </span>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { getDayRoutineStore } from "@/stores/routine.js";
import router from "@/router";

const week = new Array(
  "일요일",
  "월요일",
  "화요일",
  "수요일",
  "목요일",
  "금요일",
  "토요일"
);

const getDayRoutine = getDayRoutineStore();
const today = new Date().getDay();

const pushStart = function () {
  router.push("/start");
};

onMounted(() => {
  getDayRoutine.dayRoutineMethod("금요일");
});
</script>

<style scoped>
.video-wrapper {
  display: flex;
  justify-content: center;
}

.upline {
  display: flex;
  flex-direction: row;
  align-content: center;
  justify-content: center;
  cursor: pointer;
}
.tmp {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2em;
  color: #4a4a4a;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
}
.img {
  margin-left: 30px;
  width: 100px;
  height: 120px;
}
.fit-per-day {
  max-width: 1000px;
  margin: 0 auto;
}
</style>
