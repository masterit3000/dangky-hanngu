export interface ISinhvien {
  id?: number;
  alevel?: number;
  imgidx?: number;
  uadd?: string;
  ubirth0?: number;
  ubirth1?: number;
  ubirth2?: number;
  uemail0?: string;
  uemail1?: string;
  uhp?: string;
  ujob?: string;
  ukname?: string;
}

export const defaultValue: Readonly<ISinhvien> = {};
