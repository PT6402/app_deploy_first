import { useState } from "react";
import http from "../../http";
export default function useUser() {
  const [isLoadding, setIsLoadding] = useState();
  const [isError, setIsError] = useState();
  const getUsers = async () => {
    setIsLoadding(true);
    setIsError(null);
    try {
      const res = await http.get("http://localhost/api/user");
      if (res.status == 200) {
        return res.data;
      }
    } catch (error) {
      setIsError(error.response.data);
      return null;
    } finally {
      setIsLoadding(false);
    }
  };
  return { isLoadding, isError, getUsers };
}
