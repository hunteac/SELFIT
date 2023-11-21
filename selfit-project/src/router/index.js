import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import YoutubeView from "@/views/YoutubeView.vue";
import TodayView from "@/views/TodayView.vue";
import LogInView from "@/views/LogInView.vue";
import RegisterView from "@/views/RegisterView.vue";
import MyRoutineView from "@/views/MyRoutineView.vue";
import AboutUsView from "@/views/AboutUsView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path:"/register",
      name:"register",
      component: RegisterView,
    },
    {
      path:"/about",
      name:"about",
      component:AboutUsView,
    },
    {
      path:"/login",
      name: "login",
      component: LogInView,
    },
    {
      path: "/today",
      name: "today",
      component: TodayView,
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
  ],
});

export default router;
