import React, { useEffect, useState } from "react";
import MatchItem from "../../components/MatchItem";
import styled from "styled-components";

const Main = () => {
  const [matches, setMatches] = useState([]);

  useEffect(() => {
    //   백엔드랑 맞출 부분 : 기본 GET 방식 , 비동기로
    // CORS policy 발생한다면 !! match관련 Controller 부분에서 @CrossOrigin 추가.. (외부에서 오는 Javascipt 요청 허용해줘야함)
    // http://localhost:14122/match
    fetch("http://3.34.47.146:14122/api/matching")
      .then((res) => res.json())
      .then((res) => {
        console.log(res);
        setMatches(res); // 데이터 뿌려줌
      });
  }, []);

  return (
    <div
      style={{
        width: "375px",
        // height: "190%",
        borderRadius: "20px",
        marginBottom: "20px",
        padding: "10px 10px 10px 10px",
        backgroundColor: "#F4F4F4",
      }}
    >
      <h6
        style={{
          fontWeight: "bold",
          marginTop: "30px",
          marginBottom: "20px",
        }}
      >
        나와 맞는 매칭
      </h6>
      <ContentsBox>
        {/* DB-> 백엔드 에서 가져온 매칭 데이터들 뿌려줄 부분 */}
        {matches.map((mh) => (
          <MatchItem key={mh.id} mhg={mh} />
        ))}
      </ContentsBox>
    </div>
  );
};

export default Main;

const ContentsBox = styled.div``;
