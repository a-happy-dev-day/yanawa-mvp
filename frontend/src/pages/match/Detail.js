import React, { useEffect, useState } from 'react';

const Detail = (props) => {
  //   const {
  //     matchingId,
  //     age,
  //     content,
  //     matchingDate,
  //     maximumLevel,
  //     minimumLevel,
  //     numberOfMember,
  //     recruitmentAnnual,
  //     rentalCost,
  //     sex,
  //     teamGame,
  //     tennisCourtName,
  //     userId,
  //   } = props.match;
  //   const id = props.match.params.matchingId;

  const id = props.match.params.matchingId;

  const [match, setMatch] = useState({
    matchingId: '',
    age: '',
    content: '',
    matchingDate: '',
    maximumLevel: '',
    minimumLevel: '',
    numberOfMember: '',
    recruitmentAnnual: '',
    rentalCost: '',
    sex: '',
    teamGame: '',
    tennisCourtName: '',
    userId: '',
    id: '',
    place: '',
    date: '',
  });

  useEffect(() => {
    fetch('http://3.34.47.146:14122/api/matching/' + id)
      .then((res) => res.json())
      .then((res) => {
        setMatch(res);
      });
  }, []);

  return (
    <div>
      <h6
        style={{
          fontWeight: 'bold',
          marginTop: '30px',
          marginBottom: '20px',
        }}
      >
        매칭 자세히 보기
      </h6>
      <h6>{match.tennisCourtName}</h6>
      <h6>{match.matchingDate}</h6>
      <h6>보라매</h6>
      <h6>2022/04/25</h6>
    </div>
  );
};

export default Detail;
