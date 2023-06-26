-- Create aeroclub
insert into aeroclub (
    oaci,
    name,
    type,
    phone_Number,
    mail,
    adresse,
    code_Postal,
    commune
  )
VALUES
  (
      'LFJR',
      'Aéroport d''Angers-Loire',
      'Aéroport',
      '0241000000',
      'angersaeroport@test.fr',
      'Aéro-club Angers Marcé - Angers Loire Aéroport',
      '49100',
      'Marcé'
    );


-- Create Tarif

INSERT INTO tarif
(taxe_atterrissage, taxe_parking, carburant, aeroclub_fk)
VALUES
("10", "10", "10", 1),

