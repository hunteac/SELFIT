import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import YoutubeView from "@/views/YoutubeView.vue";
import TodayView from "@/views/TodayView.vue";
import LogInView from "@/views/LogInView.vue";
import RegisterView from "@/views/RegisterView.vue";
import MyRoutineView from "@/views/MyRoutineView.vue";
import DayRoutineView from "@/views/DayRoutineView.vue";
import AboutUsView from "@/views/AboutUsView.vue";
import StartView from "@/views/StartView.vue";
import CompleteView from "@/views/CompleteView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/register",
      name: "register",
      component: RegisterView,
    },
    {
      path: "/about",
      name: "about",
      component: AboutUsView,
    },
    {
      path: "/login",
      name: "login",
      component: LogInView,
    },
    {
      path: "/today",
      name: "today",
      component: TodayView,
    },
    {
      path: "/start",
      name: "start",
      component: StartView,
    },

    {
      path: "/youtube",
      name: "youtube",
      component: YoutubeView,
    },
    {
      path: "/myroutine",
      name: "myroutine",
      component: MyRoutineView,
    },
    {
      path: "/dayroutine",
      name: "dayroutine",
      component: DayRoutineView,
    },
    {
      path: "/complete",
      name: "complete",
      component: CompleteView,
    },
  ],
});

export default router;
