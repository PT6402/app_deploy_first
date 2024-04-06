import { useState } from "react";
import http from "../../http";

export default function useDemo() {
  const [isLoadding, setIsLoadding] = useState();
  const [isError, setIsError] = useState();
  const requestDemo = async () => {
    setIsLoadding(true);
    setIsError(false);
    try {
      const res = await http.get("/api/demo");
      if (res.status === 200) {
        return "connect backend success";
      }
    } catch (error) {
      setIsError(error.response.data);
    } finally {
      setIsLoadding(false);
    }
  };
  return { requestDemo, isLoadding, isError };
}
