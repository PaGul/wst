CREATE TABLE "Employee"
(
  id bigserial NOT NULL,
  name character varying,
  surname character varying,
  job character varying,
  salary integer,
  disability boolean NOT NULL,
  CONSTRAINT "PK_Employee" PRIMARY KEY (id)
);

INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Julia', 'Farmer', 'programmer', 45000, FALSE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Tommie', 'Vaughn', 'project manager', 50000, FALSE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Neal', 'Tyler', 'intern programmer', 20000, FALSE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Gerald', 'Carroll', 'programmer', 40000, FALSE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Andre', 'Peters', 'singer', 600000, TRUE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Pete', 'Jones', 'shoemaker', 30000, TRUE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Wm', 'Bowen', 'risk manager', 50000, FALSE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Scott', 'Guerrero', 'pilot', 80000, FALSE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Rickey', 'Barton', 'pilot', 80000, FALSE);
INSERT INTO "Employee"(name, surname,job,salary,disability) VALUES ('Dale', 'Brooks', 'writer', 0, FALSE);