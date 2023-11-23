import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useYoutubeStore = defineStore("youtube", () => {
  const videos = ref([]);

  const youtubeSearch = function (keyword) {
    const URL = "https://www.googleapis.com/youtube/v3/search";
    const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY;
    axios({
      url: URL,
      method: "GET",
      params: {
        key: API_KEY,
        part: "snippet",
        q: keyword,
        type: "video",
        maxResults: 28,
      },
    })
      .then((response) => {
        videos.value = response.data.items;
      })
      .catch(() => {});
  };

  return { videos, youtubeSearch };
});

export const useVideoStore = defineStore("select", () => {
  const videoResult = ref("");
  const videoMethod = function (data) {
    let video = {
      userId: data.userId,
      videoId: data.videoId,
    };
    axios
      .post("http://localhost:8080/videoapi/video", video, {
        header: { "Content-type": "application/json" },
      })
      .then((res) => {
        if (res.data == "success") {
          alert("영상이 성공적으로 등록됐습니다.");
        }
        videoResult.value = res.data;
      });
  };
  return {
    videoResult,
    videoMethod,
  };
});

export const getVideoListStore = defineStore("get", () => {
  const videoListResult = ref("");
  const videoListMethod = function () {
    axios
      .get(
        `http://localhost:8080/videoapi/video/${sessionStorage.getItem(
          "loginId"
        )}`
      )
      .then((res) => {
        videoListResult.value = res.data;
      });
  };
  return {
    videoListResult,
    videoListMethod,
  };
});
