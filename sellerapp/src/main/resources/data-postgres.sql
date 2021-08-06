insert into authority (role) values ('ROLE_ADMIN');
insert into authority (role) values ('ROLE_REGISTERED_USER');
insert into authority (role) values ('ROLE_INSTRUCTOR');

insert into users (type, email, password, verified) values ('admin','admin@gmail.com','$2a$10$RVzuprKddsjdq6P8QWmqF.sCj2uYPIUlbFVB.b7tJ9RdFNOOBNoXO' ,true);
insert into users (type, email, password, verified) values ('registered_user','user@gmail.com','$2a$10$RVzuprKddsjdq6P8QWmqF.sCj2uYPIUlbFVB.b7tJ9RdFNOOBNoXO' ,true);

insert into users_authority (user_id, authority_id) values (1, 1);
insert into users_authority (user_id, authority_id) values (2, 2);


insert into ski_resort (name, description, country, lift_price, gondola_price, season_starts, season_ends, group_count, ticket_deposit, capacity, active) values('Kopaonik','Skijaliste u Srbiji', 'Srbija', 4500, 1000, '2021-03-01 22:24:52', '2021-08-01 22:24:52', 20, 500, 10256, true);
insert into ski_resort (name, description, country, lift_price, gondola_price, season_starts, season_ends, group_count, ticket_deposit, capacity, active) values('Tornik','Skijaliste u Srbiji', 'Srbija', 2500, 1000, '2021-03-01 22:24:52', '2021-08-01 22:24:52', 20, 500, 8000, true);


insert into ticket_user (user_type, counts, single_ticket_price) values ('ODRASLI', 2, 100);
insert into ticket_user (user_type, counts, single_ticket_price) values ('DECA', 2, 100);
insert into ticket_user (user_type, counts, single_ticket_price) values ('SENIOR', 900, 100);

insert into ticket_user (user_type, counts, single_ticket_price) values ('ODRASLI', 2, 100);
insert into ticket_user (user_type, counts, single_ticket_price) values ('ODRASLI', 2, 100);
insert into ticket_user (user_type, counts, single_ticket_price) values ('ODRASLI', 2, 100);



insert into tickets (bill, initial_price, transport_type, type_ticket, using_start, using_end, using_period, ski_resort_id) values (12364,200, 'ZICARA', 'PORODICNA', '2021-05-25 22:24:52', '2021-05-30 22:24:52', 'DNEVNA', 1);
insert into tickets (bill, initial_price, transport_type, type_ticket, using_start, using_end, using_period, ski_resort_id) values (12364,200, 'ZICARA', 'PORODICNA', '2021-05-25 22:24:52', '2021-05-30 22:24:52', 'DNEVNA', 1);

insert into tickets (bill, initial_price, transport_type, type_ticket, using_start, using_end, using_period, ski_resort_id) values (12364,200, 'ZICARA', 'PORODICNA', '2021-04-25 00:00:00', '2021-04-28 00:00:00', 'DNEVNA', 1);
insert into tickets (bill, initial_price, transport_type, type_ticket, using_start, using_end, using_period, ski_resort_id) values (12364,200, 'ZICARA', 'PORODICNA', '2020-05-25 00:00:00', '2020-05-28 00:00:00', 'DNEVNA', 1);
insert into tickets (bill, initial_price, transport_type, type_ticket, using_start, using_end, using_period, ski_resort_id) values (12364,200, 'ZICARA', 'PORODICNA', '2020-05-25 00:00:00', '2020-05-28 00:00:00', 'DNEVNA', 1);



insert into tickets_ticket_users(tickets_id, ticket_users_id) values(1,1);
insert into tickets_ticket_users(tickets_id, ticket_users_id) values(1,2);
insert into tickets_ticket_users(tickets_id, ticket_users_id) values(2,3);

insert into tickets_ticket_users(tickets_id, ticket_users_id) values(3,4);
insert into tickets_ticket_users(tickets_id, ticket_users_id) values(4,5);
insert into tickets_ticket_users(tickets_id, ticket_users_id) values(5,6);





insert into users_tickets(registered_user_id, tickets_id) values (2, 1);
insert into users_tickets(registered_user_id, tickets_id) values (2, 2);

insert into users_tickets(registered_user_id, tickets_id) values (2, 3);
insert into users_tickets(registered_user_id, tickets_id) values (2, 4);
insert into users_tickets(registered_user_id, tickets_id) values (2, 5);

insert into insurance_company(name, description, active) values ('UNIQA', 'opis', true);
insert into insurance_company(name, description, active) values ('Dunav osiguranje', 'opis', true);
insert into insurance_company(name, description, active) values ('DDOR', 'opis', false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1,				 3450, 		true,				 true,				 true, 			true, 			false, 				true, 				true, 				true, 			true,			 false, 				false, 						false, 			false,			 false,		false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1, 				3950, 		true, 				true,			 	true, 			true, 			true, 			true, 						true, 			true, 			true, 			false, 					false, 						false, 			false, 		false, 			false);
insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1, 				4890, 		true, 				true,			 	true, 			true, 			true, 			true, 						true, 			true, 			true, 			true, 					true, 						true, 			true, 		true,			false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1, 				3950, 		true, 				true,			 	true, 			true, 			false, 			true, 						true, 			true, 			true, 			false, 					false, 						false, 			true, 		true,			false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1, 				3150, 		true, 				true,			 	true, 			true, 			false, 			false, 						false, 			true, 			false, 			false, 					false, 						false, 			false, 		false,			false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1,				 4450, 		true,				 true,				 true, 			true, 			false, 				true, 				true, 				true, 			true,			 false, 				false, 						false, 			false,			 false,		true);
insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1, 				4950, 		true, 				true,			 	true, 			true, 			true, 			true, 						true, 			true, 			true, 			false, 					false, 						false, 			false, 		false, 			true);
insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1, 				5890, 		true, 				true,			 	true, 			true, 			true, 			true, 						true, 			true, 			true, 			true, 					true, 						true, 			true, 		true,			true);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				1, 				4950, 		true, 				true,			 	true, 			true, 			false, 			true, 						true, 			true, 			true, 			false, 					false, 						false, 			true, 		true,			true);

-----
insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2,				 3370, 		true,				 true,				 true, 			true, 			false, 				true, 				true, 				true, 			true,			 false, 				false, 						false, 			false,			 false,		false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2, 				3800, 		true, 				true,			 	true, 			true, 			true, 			true, 						true, 			true, 			true, 			false, 					false, 						false, 			false, 		false, 			false);
insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2, 				4990, 		true, 				true,			 	true, 			true, 			true, 			true, 						true, 			true, 			true, 			true, 					true, 						true, 			true, 		true,			false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2, 				3800, 		true, 				true,			 	true, 			true, 			false, 			true, 						true, 			true, 			true, 			false, 					false, 						false, 			true, 		true,			false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2, 				2990, 		true, 				true,			 	true, 			true, 			false, 			false, 						false, 			true, 			false, 			false, 					false, 						false, 			false, 		false,			false);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2,				 4100, 		true,				 true,				 true, 			true, 			false, 				true, 				true, 				true, 			true,			 false, 				false, 						false, 			false,			 false,		true);
insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2, 				4950, 		true, 				true,			 	true, 			true, 			true, 			true, 						true, 			true, 			true, 			false, 					false, 						false, 			false, 		false, 			true);
insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2, 				5790, 		true, 				true,			 	true, 			true, 			true, 			true, 						true, 			true, 			true, 			true, 					true, 						true, 			true, 		true,			true);

insert into policy(insurance_company_id, price, medical_assistance, inpatient_treatment, medication, medical_supplies, orthopaedic_aids, transport_to_hospital, hospital_treatment, diagnostics, urgent_operations, accidental_death, accidental_permanent_disability, rescue_expenses, ski_equipment, extra_equipment, vip)
values (				2, 				5100, 		true, 				true,			 	true, 			true, 			false, 			true, 						true, 			true, 			true, 			false, 					false, 						false, 			true, 		true,			true);


