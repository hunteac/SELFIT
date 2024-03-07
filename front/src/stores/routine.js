import { ref } from "vue";
import { defineStore } from "pinia";
import { useRouter } from "vue-router";
import axios from "axios";

export const useRoutineStore = defineStore("routine", () => {
  const router = useRouter();
  const routineResult = ref([]);
  const routineMethod = function (data) {
    let routineVideo = {
      userId: data.userId,
      videoId: data.videoId,
      memo: data.memo,
      day: data.day,
      num: data.num,
      start: data.start,
      end: data.end,
    };
    axios
      .post(
        "http://localhost:8080/routinevideoapi/routinevideo",
        routineVideo,
        {
          header: { "Content-type": "application/json" },
        }
      )
      .then((res) => {
        if (res.data == "success") {
        } else {
          alert("루틴 등록을 실패했습니다.");
        }
        routineResult.value = res.data;
        routineResult;
      });
  };
  return {
    routineResult,
    routineMethod,
  };
});

export const getDayRoutineStore = defineStore("getDayRoutine", () => {
  const dayRoutineResult = ref("");
  const dayRoutineMethod = function (data) {
    axios
      .get(
        `http://localhost:8080/routinevideoapi/routinevideo/${sessionStorage.getItem(
          "loginId"
        )}/${data}`
      )
      .then((res) => {
        dayRoutineResult.value = res.data;
      });
  };
  return {
    dayRoutineResult,
    dayRoutineMethod,
  };
});

export const deleteDayRoutineStore = defineStore("deleteDayRoutine", () => {
  const router = useRouter();
  const deleteRoutineResult = ref("");
  const deleteRoutineMethod = function (data) {
    console.log(data.loginId);
    console.log(data.videoId);
    console.log(data.day);
    axios
      .delete(
        `http://localhost:8080/routinevideoapi/routinevideo/${data.loginId}/${data.videoId}/${data.day}`
      )
      .then((res) => {
        deleteRoutineResult.value = res.data;
      });
  };
  return {
    deleteRoutineResult,
    deleteRoutineMethod,
  };
});
