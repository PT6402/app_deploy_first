/* eslint-disable no-undef */
import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vitejs.dev/config/
export default defineConfig(() => {
  return {
    base: "/",
    plugins: [react()],
    server: {
      port: 3000,
      strictPort: true,
      host: true,
      origin: "http://0.0.0.0:3000",
    },
    preview: {
      port: 3000,
      strictPort: true,
    },
    build: {
      outDir: "build",
    },
  };
});
