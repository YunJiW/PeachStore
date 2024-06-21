<!-- Header.vue -->
<template>
    <header>
      <div class="logo">Peach Store</div>
      <nav>
        <router-link to="/">홈</router-link>
        <router-link to="/products">상품 목록</router-link>
        <router-link to="/about">회사 소개</router-link>
      </nav>
    </header>
  </template>
  
  <script>
  export default {
    name: 'AppHeader'
  }
  </script>
  
  <style scoped>
  /* scoped style */
  header {
    background-color: #f0f0f0;
    padding: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .logo {
    font-size: 24px;
    font-weight: bold;
  }
  
  nav {
    display: flex;
  }
  
  nav a {
    margin: 0 10px;
    text-decoration: none;
    color: #333;
  }
  
  nav a:hover {
    text-decoration: underline;
  }
  </style>
  