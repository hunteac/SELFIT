import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import YoutubeView from "@/views/YoutubeView.vue";
import BoardView from "@/views/BoardView.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardCreate from "@/components/board/BoardCreate.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardUpdate from "@/components/board/BoardUpdate.vue";
import CalenderView from "@/views/CalenderView.vue";
import Calender from "@/components/calender/Calender.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/youtube",
      name: "youtube",
      component: YoutubeView,
    },
    {
      path: "/board",
      name: "board",
      component: BoardView,
      children: [
        {
          path: "",
          name: "boardList",
          component: BoardList,
        },
        {
          path: "create",
          name: "boardCreate",
          component: BoardCreate,
        },
        {
          path: ":id",
          name: "boardDetail",
          component: BoardDetail,
        },
        {
          path: "update",
          name: "boardUpdate",
          component: BoardUpdate,
        },

      ],
    },
    {
      path: "/calender",
      name: "calender",
      component: CalenderView,
      children : [
        {
          path: "",
          name: "Calender",
          component: Calender,
        },
      ],
    }
  ],
});

export default router;
