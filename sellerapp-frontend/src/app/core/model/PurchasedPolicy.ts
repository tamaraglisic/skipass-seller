import { Policy } from "./Policy";
import { Tickets } from "./Tickets";

export interface PurchasedPolicy {
    id?: number;
    policy?: Policy;
    tickets?: Tickets;
    used?: boolean;
    description?: string;
    usingStart?: Date;
    usingEnd?: Date;
}