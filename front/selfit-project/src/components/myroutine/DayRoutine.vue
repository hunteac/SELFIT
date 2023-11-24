<template>
  <div>
    <!-- <div class="button-container">
      <button
        @click="(perDay = day + `요일`), getPerDay()"
        v-for="day in days"
        :key="day"
      >
        {{ day }}
      </button>
    </div> -->
    <div class="videos-container" v-if="getDayRoutine.dayRoutineResult">
      <span
        class="video-container"
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
        <div
          class="store-button"
          @click="deleteRoutineVideo(routineVideo.videoId)"
        >
          <button
            @click="deleteRoutineVideo(routineVideo.videoId)"
            class="w-btn-outline w-btn-yellow-outline"
            type="button"
          >
            삭제
          </button>
        </div>
      </span>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { getDayRoutineStore } from "@/stores/routine.js";
import { deleteDayRoutineStore } from "@/stores/routine.js";
import router from "@/router";

const perDay = ref("");
const data = ref({});

console.log(perDay.value);

const days = ref(["전체", "월", "화", "수", "목", "금", "토", "일"]);

const getDayRoutine = getDayRoutineStore();
const deleteDayRoutine = deleteDayRoutineStore();

const getPerDay = function () {
  if (perDay.value == "전체요일") {
    router.push({
      path: "/myroutine",
    });
  } else {
    router.push({
      path: "/dayroutine",
      state: {
        day: perDay.value,
      },
    });
  }
};

const deleteRoutineVideo = function (videoURL) {
  data.value = {
    videoId: videoURL,
    day: perDay.value,
  };
  console.log(data.value);
  deleteDayRoutine.deleteRoutineMethod(data.value);
};

onMounted(() => {
  getDayRoutine.dayRoutineMethod(perDay.value);
});
</script>

<style scoped>
.videos-container {
  padding-top: 3%;
  padding-left: 3%;
  padding-right: 3%;
  padding-bottom: 3%;
  display: flex;
  position: absolute;
  flex-wrap: wrap;
}

.video-container {
  margin-left: 1%;
  margin-bottom: 1%;
  width: 480px;
  display: flex;
}

.video {
  border-radius: 15px;
}

.store-button {
  margin: 0 auto;
  margin-left: 1%;
  margin-right: 1%;
  display: flex;
  align-items: center;
  height: 300px;
  background-color: antiquewhite;
  border-radius: 15px;
}

.button-container {
  display: flex;
  justify-content: space-around; /* 버튼들 사이에 동일한 간격을 유지 */
  width: 60%; /* 전체 페이지의 70% 너비를 차지 */
  margin: 0 auto; /* 수평 중앙 정렬 */
  margin-bottom: 20px;
}

.button-container button {
  padding: 20px 30px;
  border: 1px solid #ccc;
  background-color: #fefefe;
  flex-grow: 0; /* 버튼 크기를 고정 */
  flex-shrink: 0; /* 화면 크기가 줄어들 때 버튼 크기 유지 */
  flex-basis: auto; /* 기본 버튼 크기 설정 */
  border-radius: 15px;
}
.w-btn-outline {
  padding: 5px 15px;
  border-radius: 15px;
  font-family: "paybooc-Light", sans-serif;
  text-decoration: none;
  font-size: 20px;
  font-weight: 600;
  transition: 0.25s;
}
</style>
