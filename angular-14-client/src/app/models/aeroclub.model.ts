export class Aeroclub {
  id?: any;
  oaci?: string;
  name?: string;
  type?: string;
  phoneNumber?: string;
  mail?: string;
  adresse?: string;
  codePostal?: string;
  commune?: string;

  constructor(aeroclub: any){
    {
      this.id = aeroclub.id;
      this.oaci = aeroclub.make || '';
      this.name = aeroclub.model || '';
      this.type = aeroclub.color || '';
      this.phoneNumber = aeroclub.phoneNumber || '';
      this.mail = aeroclub.mail || '';
      this.adresse = aeroclub.adresse || '';
      this.codePostal = aeroclub.codePostal || '';
      this.commune = aeroclub.commune || '';
    }
  }
}