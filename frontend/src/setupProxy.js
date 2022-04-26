const { createProxyMiddleware } = require("http-proxy-middleware");

// src/setupProxy.js
module.exports = function (app) {
  app.use(
    createProxyMiddleware("/api", {
      target: "http://3.34.47.146:14122", // 비즈니스 서버 URL 설정
      changeOrigin: true,
    })
  );
};
