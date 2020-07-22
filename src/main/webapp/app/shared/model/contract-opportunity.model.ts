import { Moment } from 'moment';

export interface IContractOpportunity {
  id?: number;
  contractId?: string;
  title?: string;
  sol?: string;
  agency?: string;
  subTier?: string;
  office?: string;
  posteddate?: Moment;
  type?: string;
  basetype?: string;
  setasidecode?: string;
  setaside?: string;
  responsedeadline?: Moment;
  naicscode?: string;
  classificationcode?: string;
  popstate?: string;
  popzip?: string;
  popcountry?: string;
  active?: string;
  organizationtype?: string;
  description?: any;
}

export class ContractOpportunity implements IContractOpportunity {
  constructor(
    public id?: number,
    public contractId?: string,
    public title?: string,
    public sol?: string,
    public agency?: string,
    public subTier?: string,
    public office?: string,
    public posteddate?: Moment,
    public type?: string,
    public basetype?: string,
    public setasidecode?: string,
    public setaside?: string,
    public responsedeadline?: Moment,
    public naicscode?: string,
    public classificationcode?: string,
    public popstate?: string,
    public popzip?: string,
    public popcountry?: string,
    public active?: string,
    public organizationtype?: string,
    public description?: any
  ) {}
}
