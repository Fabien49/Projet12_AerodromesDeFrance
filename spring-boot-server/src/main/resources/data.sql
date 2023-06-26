-- Create aeroclub
insert into aeroclub (
    aeroclub_id,
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
        1,
      'LFJR',
      'Aéroport d''Angers-Loire',
      'Aéroport',
      '0241000000',
      'angersaeroport@test.fr',
      'Aéro-club Angers Marcé - Angers Loire Aéroport',
      '49100',
      'Marcé'
    );


---- Create Tarif
--
--INSERT INTO tarif
--(tarif_id, taxe_atterrissage, taxe_parking, carburant, aeroclub_id)
--VALUES
--(2, "10", "10", "10", 1),

