import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';

const SaveForm = (props) => {
  const [match, setMatch] = useState({
    place: '',
    date: '',
    level: '',
    age: '',
    sex: '',
    pref: '',
    personel: '',
    cost: '',
    saying: '',
  });

  const changeValue = (e) => {
    setMatch({
      ...match,
      [e.target.name]: e.target.value,
    });
  };

  const submitMatch = (e) => {
    e.preventDefault();
    fetch('http://localhost:8080/match', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(match),
    })
      .then((res) =>
        //   res.JSON()
        {
          if (res.status === 201) {
            // console.log(res); // 값 체킹
            return res.JSON();
          } else {
            return null;
          }
        },
      )
      .then((res) => {
        // 백엔드 서버 실행 후 넘기는 값 테스트 해 볼 부분
        console.log(res);
        if (res !== null) {
          // 일단 등록 성공 후 매칭리스트(메인)페이지로 가도록 .. 현재 기획안 상태에서는 완성 상세 페이지로 가게 되어있는데.. 이 부분은 구현현황에 따라 변경
          props.history.push('/');
        } else {
          alert('오류로 인해 매칭 등록이 안되었습니다.');
        }
      });
  };

  return (
    <div>
      <h6
        style={{
          fontWeight: 'bold',
          marginTop: '30px',
          marginBottom: '20px',
        }}
      >
        매칭 만들기
      </h6>
      <Form onSubmit={submitMatch}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>코트장 선택</Form.Label>
          <Form.Control
            type="text"
            placeholder="코드장 입력"
            onChange={changeValue}
            name="place"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>일시</Form.Label>
          <Form.Control
            type="text"
            placeholder="날짜/시간 선택"
            onChange={changeValue}
            name="date"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>NTRP 레벨</Form.Label>
          <Form.Control
            type="text"
            placeholder="레벨 입력"
            onChange={changeValue}
            name="level"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>모집연령</Form.Label>
          <Form.Control
            type="text"
            placeholder="모집 연령 입력"
            onChange={changeValue}
            name="age"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>모집 성별</Form.Label>
          <Form.Control
            type="text"
            placeholder="모집성별"
            onChange={changeValue}
            name="sex"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>선호게임</Form.Label>
          <Form.Control
            type="text"
            placeholder="매칭 / 랠리"
            onChange={changeValue}
            name="pref"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>모집인원</Form.Label>
          <Form.Control
            type="text"
            placeholder="2명 / 4명"
            onChange={changeValue}
            name="personel"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>코트비용</Form.Label>
          <Form.Control
            type="text"
            placeholder="1인 코트 비용 입력 (원)"
            onChange={changeValue}
            name="cost"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>하고 싶은 말</Form.Label>
          <Form.Control
            type="text"
            placeholder="매칭할 상대에게 하고 싶은 말을 적어주세요."
            onChange={changeValue}
            name="saying"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>

        <Button
          variant="primary"
          type="submit"
          style={{
            alignItems: 'end',
          }}
        >
          매칭 만들기 완료
        </Button>
      </Form>
    </div>
  );
};

export default SaveForm;
