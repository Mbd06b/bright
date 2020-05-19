import { UserLinkView } from './userlinkview';

export interface IdeaInterface {
  id: number;
  title: string;
  subtitle: string;
  story: string;
  upVotes: number;
  downVotes: number;
  actingEntityId: number;

  action: string;

  users: UserLinkView [];
}
