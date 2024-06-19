<!-- Footer.vue -->
<template>
  <footer>
    <p>&copy; 2024 Peach Store. All rights reserved.</p>
    <nav>
      <router-link to="/terms">이용약관</router-link>
      <router-link to="/privacy">개인정보 처리방침</router-link>
      <router-link to="/contact">고객센터</router-link>
    </nav>
  </footer>
</template>

<script>
export default {
  name: 'AppFooter'
}
</script>

<style scoped>
/* scoped style */
footer {
  background-color: #333;
  color: white;
  padding: 10px;
  text-align: center;
}

footer nav {
  margin-top: 10px;
}

footer nav a {
  color: white;
  text-decoration: none;
  margin: 0 10px;
}

footer nav a:hover {
  text-decoration: underline;
}
</style>
