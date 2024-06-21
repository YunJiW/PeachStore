<!-- ProductList.vue -->
<template>
    <div class="product-list">
      <div class="product-card">
        <h3>복숭아 1호</h3>
        <p>신선하고 달콤한 복숭아</p>
        <p>가격: ₩10,000</p>
      </div>
      <div class="product-card">
        <h3>복숭아 2호</h3>
        <p>새콤한 맛이 일품인 복숭아</p>
        <p>가격: ₩12,000</p>
      </div>
      <!-- 추가적인 상품 카드를 필요에 따라 렌더링 -->
    </div>
  </template>
  
  <script>
  export default {
    name: 'ProductList'
  }
  </script>
  
  <style scoped>
  /* scoped style */
  .product-list {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 20px;
  }
  
  .product-card {
    background-color: #f9f9f9;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    text-align: center;
  }
  </style>
  