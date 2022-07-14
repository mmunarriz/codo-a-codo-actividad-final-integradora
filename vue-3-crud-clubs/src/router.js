import { createWebHistory, createRouter } from "vue-router";

const routes =  [
  {
    path: "/",
    alias: "/clubs",
    name: "clubs",
    component: () => import("./components/ClubsList")
  },
  {
    path: "/clubs/:id",
    name: "club-details",
    component: () => import("./components/Club")
  },
  {
    path: "/add",
    name: "add",
    component: () => import("./components/AddClub")
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;