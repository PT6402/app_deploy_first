import { useEffect, useState } from "react";
import ItemUser from "./common/ItemUser";
import PlusIcon from "./common/PlusIcon";
import useUser from "../hooks/useUser";

export default function UserPage() {
  const { getUsers } = useUser();
  const [data, setData] = useState([]);
  useEffect(() => {
    getUsers().then((res) => res != null && setData(res));
  }, []);
  console.log(data);
  return (
    <section className="text-gray-600 body-font">
      <div className="container px-5 py-24 mx-auto">
        <div className="flex flex-col text-center w-full mb-20">
          <div className={"flex items-center justify-center gap-5"}>
            <h1 className="sm:text-3xl text-2xl font-medium title-font mb-4 text-gray-900">
              List User
            </h1>
            <div
              className={"self-center  p-5 rounded-xl border-4 cursor-pointer"}
            >
              <PlusIcon />
            </div>
          </div>
        </div>
        <div className="flex flex-wrap -m-2 ">
          {data.length > 0 &&
            data.map((item) => {
              return (
                <ItemUser key={item.id} name={item.name} email={item.email} />
              );
            })}
        </div>
      </div>
    </section>
  );
}
