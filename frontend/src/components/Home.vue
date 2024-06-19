<!-- Home.vue -->
<template>
  <div class="home">
    <section class="banner">
      <h1>환영합니다, 복숭아 판매 사이트입니다!</h1>
      <p>신선하고 맛있는 복숭아를 만나보세요.</p>
    </section>

    <section class="products">
      <h2>인기 상품</h2>
      <ProductList />
    </section>
  </div>
</template>

<script>
import ProductList from '@/components/ProductList.vue';

export default {
  name: 'Home',
  components: {
    ProductList
  }
}
</script>

<style scoped>
/* scoped style */
.home {
  max-width: 1200px;
  margin: 0 auto;
}

.banner {
  background-color: #f9f9f9;
  padding: 20px;
  text-align: center;
}

.products {
  margin-top: 20px;
}
</style>
