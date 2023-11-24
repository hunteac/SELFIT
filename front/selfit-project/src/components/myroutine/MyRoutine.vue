<template>
  <div>
    <div class="button-container">
      <button
        @click="(perDay = day + `요일`), getPerDay()"
        v-for="day in days"
        :key="day"
      >
        {{ day }}
      </button>
    </div>
    <div class="videos-container" v-if="getVideoList.videoListResult">
      <span
        class="video-container"
        v-for="video in getVideoList.videoListResult"
        :key="video.videoId"
      >
        <div>
          <iframe
            class="video"
            id="videoList"
            title="iframe Example 2"
            width="400"
            height="300"
            style="border: none"
            :src="video.videoId"
          ></iframe>
        </div>
        <div
          class="store-button"
          @click="
            isRoutineDetail = true;
            videoURL = video.videoId;
          "
        >
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
        </div>
      </span>
    </div>
  </div>
  <div v-if="isRoutineDetail" id="modalWrap">
    <div id="modalContent">
      <div id="modalBody">
        <span @click="isRoutineDetail = false" id="closeBtn">&times;</span>
        <div id="modalContent">
          <form v-on:submit.prevent="storeRoutine">
            <div style="height: 100px"></div>
            <div style="display: flex; justify-content: center">
              <select name="day" id="day" class="select" v-model="day">
                <option value="" selected disabled hidden>요일 선택</option>
                <option value="월요일">MON</option>
                <option value="화요일">TUE</option>
                <option value="수요일">WED</option>
                <option value="목요일">THU</option>
                <option value="금요일">FRI</option>
                <option value="토요일">SAT</option>
                <option value="일요일">SUN</option>
              </select>
            </div>
            <div style="height: 30px"></div>
            <div
              style="
                display: flex;
                flex-direction: row;
                justify-content: space-between;
              "
            >
              <input
                id="input"
                type="number"
                name="num"
                placeholder="순서"
                v-model="num"
              />
              <input
                id="input"
                type="number"
                name="start"
                placeholder="시작시간"
                v-model="start"
              />
              <input
                id="input"
                type="number"
                name="end"
                placeholder="종료시간"
                v-model="end"
              />
            </div>
            <div style="height: 30px"></div>
            <div>
              <textarea
                name="memo"
                id="memo"
                cols="30"
                rows="10"
                placeholder="메모를 입력하세요."
                v-model="memo"
              ></textarea>
            </div>
            <br />
            <div style="display: flex; justify-content: center">
              <button
                type="submit"
                style="font-weight: bold; font-size: 30px; color: #777"
              >
                추가
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { getVideoListStore } from "@/stores/youtube.js";
import { useRoutineStore } from "@/stores/routine.js";
import router from "@/router";

const num = ref("");
const day = ref("");
const memo = ref("");
const start = ref("");
const end = ref("");
const data = ref({});
const videoURL = ref("");
const perDay = ref("");
const days = ref(["전체", "월", "화", "수", "목", "금", "토", "일"]);

const routineStore = useRoutineStore();
const getVideoList = getVideoListStore();
const isRoutineDetail = ref(false);

onMounted(() => {
  getVideoList.videoListMethod();
});

const getPerDay = function () {
  if (perDay.value != "전체요일") {
    router.push({
      path: "/dayroutine",
      state: {
        day: perDay.value,
      },
    });
  }
};

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
  isRoutineDetail.value = false;
  routineStore.routineMethod(data.value);
};
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

#modalWrap {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

#modalBody {
  width: 700px;
  height: 700px;
  padding: 30px 50px;
  margin: 0 auto;
  margin-top: 3%;
  border: 1px solid #777;
  background-color: antiquewhite;
}

#modalContent {
  height: 600px;
  padding: 30px 50px;
}

#closeBtn {
  float: right;
  font-weight: bold;
  color: #777;
  font-size: 50px;
  cursor: pointer;
}

select {
  -moz-appearance: none;
  -webkit-appearance: none;
  appearance: none;
}

input {
  width: 150px;
  height: 80px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 10%;
  background-color: #f8f8f8;
  font-size: 25px;
  resize: none;
  text-align: center;
}

input:focus,
textarea:focus {
  outline: 3px solid gray;
}

input::-webkit-inner-spin-button {
  appearance: none;
  -moz-appearance: none;
  -webkit-appearance: none;
}

input::placeholder,
textarea::placeholder {
  color: black;
  text-align: center;
}

textarea {
  width: 100%;
  height: 150px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  font-size: 25px;
  resize: none;
}

.select {
  width: 200px;
  height: 70px;
  border: 2px solid #ccc;
  box-sizing: border-box;
  border-radius: 10px;
  font-weight: 400;
  font-size: 25px;
  background-color: #f8f8f8;
  text-align: center;
}

.select:focus {
  box-sizing: border-box;
  border-radius: 10px;
  outline: 2px solid #777;
  border-radius: 10px;
  font-size: 25px;
  text-align: center;
}
</style>
