import { Role } from './role.enum';
import { IdeaLinkView } from './idealinkview';
import { Idea } from './idea';

export interface UserInterface {
  id: number;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  title: string;
  aboutMe: string;
  userImgUrl: string;
  avatarUrl: string;

  token: string;
  role: string;

  ideas: Idea[];
  ideaLinks: IdeaLinkView[];


}
