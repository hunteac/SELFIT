<template>
  <div>
    <div class="black-bg" v-if="isRoutineDetail">
      <div class="white-bg">
        <form v-on:submit.prevent="storeRoutine">
          <select name="day" id="day" v-model="day">
            <option value="" selected disabled hidden>요일</option>
            <option value="월요일">MON</option>
            <option value="화요일">TUE</option>
            <option value="수요일">WED</option>
            <option value="목요일">THU</option>
            <option value="금요일">FRI</option>
            <option value="토요일">SAT</option>
            <option value="일요일">SUN</option>
          </select>
          <br />
          <input type="number" name="num" placeholder="순서" v-model="num" />
          <br />
          <br />
          <input
            type="number"
            name="start"
            placeholder="시작시간"
            v-model="start"
          />
          <br />
          <br />
          <input
            type="number"
            name="end"
            placeholder="종료시간"
            v-model="end"
          />
          <br />
          <br />
          <textarea
            name="memo"
            id="memo"
            cols="30"
            rows="10"
            placeholder="메모"
            v-model="memo"
          ></textarea>
          <br />
          <button type="submit" style="font-weight: bold">추가</button>
          <button @click="isRoutineDetail = false" style="font-weight: bold">
            닫기
          </button>
        </form>
      </div>
    </div>
    <div class="button-container">
      <button v-for="day in days" :key="day">{{ day }}</button>
    </div>
    <div v-if="getVideoList.videoListResult">
      <span
        v-for="video in getVideoList.videoListResult"
        :key="video.videoId"
        class="video-wrapper"
      >
        <iframe
          id="videoList"
          title="iframe Example 2"
          width="400"
          height="300"
          style="border: none"
          :src="video.videoId"
        ></iframe>
        <button
          @click="
            isRoutineDetail = true;
            videoURL = video.videoId;
          "
          class="w-btn-outline w-btn-yellow-outline"
          type="button"
        >
          담기
        </button>
      </span>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { getVideoListStore } from "@/stores/youtube.js";
import { useRoutineStore } from "@/stores/routine.js";

const num = ref("");
const day = ref("");
const memo = ref("");
const start = ref("");
const end = ref("");
const data = ref({});
const videoURL = ref("");
const days = ref(["월", "화", "수", "목", "금", "토", "일"]);

const routineStore = useRoutineStore();
const getVideoList = getVideoListStore();
const isRoutineDetail = ref(false);

onMounted(() => {
  getVideoList.videoListMethod();
});

const storeRoutine = function () {
  data.value = {
    userId: sessionStorage.getItem("loginId"),
    videoId: videoURL.value,
    memo: memo.value,
    day: day.value,
    num: num.value,
    start: start.value,
    end: end.value,
  };
  routineStore.routineMethod(data.value);
};
</script>

<style scoped>
body {
  margin: 0;
}
.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  padding: 20px;
}
.white-bg {
  width: 100%;
  background: #f5d042;
  border-radius: 15px;
  padding: 20px;
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
}
.w-btn-outline {
  position: relative;
  padding: 5px 10px;
  border-radius: 15px;
  font-family: "paybooc-Light", sans-serif;
  text-decoration: none;
  font-weight: 600;
  transition: 0.25s;
}

.w-btn-yellow-outline {
  border: 3px solid #fce205;
  color: #6e6e6e;
}

.w-btn-yellow-outline:hover {
  background-color: #fce205;
  color: #6e6e6e;
}

input::-webkit-inner-spin-button {
  appearance: none;
  -moz-appearance: none;
  -webkit-appearance: none;
}

input::placeholder {
  color: black;
}
</style>
