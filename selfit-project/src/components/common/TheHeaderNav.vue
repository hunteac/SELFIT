<template>
    <div id="container">
        <header>
          <img src="@/assets/ssafit_logo.jpg" alt="SSAFIT 로고" class="logo">
            <nav>
                <RouterLink to="/"> 오늘의 운동 </RouterLink> |
                <RouterLink to="/youtube"> 영상 검색 </RouterLink> |
                <RouterLink :to="{ name: 'boardList' }"> 내 루틴 관리</RouterLink> |
                <RouterLink :to="{ name: 'calender' }">캘린더 보기</RouterLink> |
            </nav>
        </header>
    </div>
</template>

<script setup>

</script>

<style  scoped>
#container {
    text-align: center;
}
.logo {
  float: left; /* 로고를 왼쪽으로 정렬 */
  height: 70px; /* 로고 크기 조정, 필요에 따라 변경 가능 */
  margin-top: 15px;
  position: relative; /* 상대 위치 설정 */
  left: 20px; /* 왼쪽에서부터의 거리, 로고를 오른쪽으로 이동 */
}


nav {
    padding: 30px
}

nav a {
    font-weight: bold;
    text-decoration: none;
    color: black;
}

nav a.router-link-exact-active {
    color: #42b983
}
</style>