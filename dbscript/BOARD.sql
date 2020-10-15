-- BOARD TABLE SCRIPT FILE
DROP TABLE BOARD CASCADE CONSTRAINTS;

CREATE TABLE BOARD (
  BOARD_NUM NUMBER,           -- �Խñ� ��ȣ
  BOARD_TITLE VARCHAR2(50),      -- �Խñ� ����
  BOARD_WRITER VARCHAR2(15),    -- �Խñ� �ۼ���
  BOARD_CONTENT VARCHAR2(2000), -- �Խñ� ����
  BOARD_ORIGINAL_FILENAME VARCHAR2(100),-- ���ε��� ���� ���ϸ�
  BOARD_RENAME_FILENAME VARCHAR2(100),  -- �ٲ� ���ϸ�
  BOARD_DATE  DATE  DEFAULT SYSDATE,-- �Խñ� �ø� ��¥
  BOARD_LEVEL  NUMBER  DEFAULT 0,-- �۷��� : ���� 0, ������ ��� 1, ����� ��� 2
  BOARD_REF  NUMBER, 
  -- �����϶��� �ڱ��ȣ, ����� �� �����ϴ� ���� ��ȣ
  BOARD_REPLY_REF NUMBER,
  -- �����϶��� 0, ������ 1�̸� �ڱ��ȣ, ������ 2�̸� �����ϴ� ��۹�ȣ
  BOARD_REPLY_SEQ  NUMBER  DEFAULT 0, -- ����� ����
  BOARD_READCOUNT  NUMBER  DEFAULT 0, -- ��ȸ��
  CONSTRAINT PK_BOARD PRIMARY KEY (BOARD_NUM),
  CONSTRAINT FK_BOARD_WRITER FOREIGN KEY (BOARD_WRITER) REFERENCES MEMBER (USERID) ON DELETE SET NULL,
  CONSTRAINT FK_BOARD_REF FOREIGN KEY (BOARD_REF) REFERENCES BOARD (BOARD_NUM) ON DELETE CASCADE,
  CONSTRAINT FK_BOARD_REPLY_REF FOREIGN KEY (BOARD_REPLY_REF) REFERENCES BOARD (BOARD_NUM) ON DELETE CASCADE
);

COMMENT ON COLUMN BOARD.BOARD_NUM IS '�Խñ۹�ȣ';
COMMENT ON COLUMN BOARD.BOARD_WRITER IS '�Խñ��ۼ��� ���̵�';
COMMENT ON COLUMN BOARD.BOARD_TITLE IS '�Խñ�����';
COMMENT ON COLUMN BOARD.BOARD_CONTENT IS '�Խñ۳���';
COMMENT ON COLUMN BOARD.BOARD_DATE IS '�Խñۿø���¥';
COMMENT ON COLUMN BOARD.BOARD_ORIGINAL_FILENAME IS '÷�����Ͽ����̸�';
COMMENT ON COLUMN BOARD.BOARD_RENAME_FILENAME IS '÷�����Ϻ����̸�';
COMMENT ON COLUMN BOARD.BOARD_LEVEL IS '�۷���';
COMMENT ON COLUMN BOARD.BOARD_REF IS '�������۹�ȣ';
COMMENT ON COLUMN BOARD.BOARD_REPLY_REF IS '������۹�ȣ';
COMMENT ON COLUMN BOARD.BOARD_REPLY_SEQ IS '��ۼ���';
COMMENT ON COLUMN BOARD.BOARD_READCOUNT IS '��ȸ��';

INSERT INTO BOARD VALUES (1, '������ �Խñ�', 'admin', 
'���� ����Ʈ�� �̿��� �ּż� �����մϴ�.', NULL, NULL, SYSDATE,
0, 1, NULL, 0, 0);

INSERT INTO BOARD VALUES (2, 'MVC Model2 �����̶�', 
'user01', '�� ���ø����̼� ���� ��� �� �ϳ��Դϴ�.', NULL, NULL,
DEFAULT, DEFAULT, 2, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (3, '������ 2', 
'user02', 
'�� ���ø����̼� ���� ��� �� �ι�° ����� �� ���� ���� �տ� First Controller �� �δ� ���Դϴ�..', 
NULL, NULL,
DEFAULT, DEFAULT, 3, NULL,  DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (4, '������3', 
'user02', '�� ���ø����̼� ���� ��� �� ����° ����� Front Controller ������ ����Ǵ� ��Ʈ�ѷ����� ������ �ƴ� �ڹ� Ŭ������ �ۼ��ؼ� �����ϴ� ����Դϴ�.', 
NULL, NULL,
DEFAULT, DEFAULT, 4, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (5, 'MVC Model1 ����', 
'user01', '�� ���ø����̼� ���� ��� �� JSP ������ ��� ��Ʈ�ѷ� �ΰ��� �ٸ� ó���ϴ� ����Դϴ�.', 
NULL, NULL,
DEFAULT, DEFAULT, 5, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (6, 'JSP��', 
'user02', 'Java Server Page �� ����', NULL, NULL,
DEFAULT, DEFAULT, 6, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (7, 'Servlet �̶�', 
'user01', '�������� �����Ǵ� �� �Ծ��� ����� Java EE ����� �����ϴ� ���� ó���� Ŭ������.', 
NULL, NULL,
DEFAULT, DEFAULT, 7, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (8, 'JSP Elements ��', 
'admin', 'Derective(������) �±�, Decleation(����) �±�, Scriptlet �±�, Expression �±�, Comment �±װ� �ִ�.', 
NULL, NULL,
DEFAULT, DEFAULT, 8, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (9, 'HTML5', 
'user02', '���ο� �� ǥ�ر���� ��� ����̽� ��ġ�� ���������� �����ϰ� �۵��Ǵ� �� �������� ����� ���� ����� �����Ѵ�.', 
NULL, NULL,
DEFAULT, DEFAULT, 9, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (10, 'CSS3', 
'user02', '�� �������� �ٹ̱� ���� ��Ÿ�Ͻ�Ʈ�� HTML5 ������ ���߾� �Ӽ����� ���׷��̵� �Ǿ���.', 
NULL, NULL,
DEFAULT, DEFAULT, 10, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (11, 'JavaScript ��', 
'user01', '�� ǥ�� 2.0 ���� ���� �߰��� ������ API ���� �����Ѵ�.', NULL, NULL,
DEFAULT, DEFAULT, 11, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (12, 'jQuery ��', 
'user01', '�ڹٽ�ũ��Ʈ ���� �ҽ� ���̺귯���� �ϳ��� html ��ҵ��� css �����ڸ� �̿��Ͽ� ���� ������ �� �ִ� ��ɵ��� �����Ѵ�..', 
NULL, NULL,
DEFAULT, DEFAULT, 12, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (13, 'ajax ��', 
'user02', 'asynchronos javascript and xml �� ���Ӹ��� ������ ������ ���� ����ϴ� �ڹٽ�ũ��Ʈ ����̴�.', 
NULL, NULL,
DEFAULT, DEFAULT, 13, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (14, '����(Filter) ��', 
'user01', 'Ŭ���̾�Ʈ ��û�� ���񽺰� �������� ���޵Ǳ� ���� ���� �����Ǵ� Ŭ�����̴�.', 
NULL, NULL,
DEFAULT, DEFAULT, 14, NULL, DEFAULT, DEFAULT);

INSERT INTO BOARD VALUES (15, '����(Wrapper) ��', 
'user02', '���Ͱ� ����æ ��û�� ���� ������ ó���� ����ϴ� Ŭ�����̴�.', NULL, NULL,
DEFAULT, DEFAULT, 15, NULL, DEFAULT, DEFAULT);

COMMIT;










